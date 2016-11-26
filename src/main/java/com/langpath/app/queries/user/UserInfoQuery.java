package com.langpath.app.queries.user;

import com.google.inject.Inject;
import com.google.inject.name.Named;
import com.langpath.app.model.storage.WordGroup;
import com.langpath.app.model.query.RequestObjectId;
import com.langpath.app.model.response.AxisValue;
import com.langpath.app.model.response.ChartData;
import com.langpath.app.model.response.UserInfo;
import com.langpath.app.model.storage.Language;
import com.langpath.app.model.storage.User;
import com.langpath.app.queries.QueryService;
import org.apache.log4j.Logger;
import org.mongodb.morphia.Datastore;

import java.util.*;
import java.util.concurrent.TimeUnit;

import static java.util.stream.Collectors.*;

public class UserInfoQuery implements QueryService<RequestObjectId, UserInfo> {

    @Inject
    private Logger logger;

    @Inject
    @Named("datastore")
    private Datastore datastore;

    @Override
    public UserInfo query(RequestObjectId criteria) {
        logger.info("User info query");
        try {
            final Random r = new Random();
            UserInfo info = new UserInfo();
            User user = datastore.createQuery(User.class).filter("_id", criteria.getId()).get();
            List<WordGroup> wordGroups = datastore.createQuery(WordGroup.class).filter("_id in", user.getWordGroupIds()).retrievedFields(true, "lastActive", "countOfRepetition", "countOfWords", "targetLang").asList();
            List<ChartData> chartDatas = new ArrayList<>();
            Map<Language, List<WordGroup>> map;
            map = wordGroups.stream().collect(groupingBy(g -> g.getTargetLang(), mapping((WordGroup g) -> g, toList())));
            map.forEach((k, v) -> {
                ChartData chartData = new ChartData();
                chartData.setLabel(k.getLabel());
                List<AxisValue> data = new ArrayList<>();
                v.forEach(wordGroup -> {
                    AxisValue value = new AxisValue();
                    value.setX(getDaysDiff(wordGroup.getLastActive()));
                    value.setY(wordGroup.getCountOfRepetition());
                    value.setZ(wordGroup.getCountOfWords());
                    data.add(value);
                });
                chartData.setData(data);
                chartData.setColor(String.format("#%02x%02x%02x", r.nextInt(256), r.nextInt(256), r.nextInt(256)));
                chartDatas.add(chartData);
            });
            info.setChartDatas(chartDatas);
            info.setFirstName(user.getFirstName());
            info.setCountMessages(0);
            info.setCountWordGroup(wordGroups.size());
            return info;
        }
        catch (Exception ex) {
            logger.error("Problem during retrieving data, ", ex);
        }
        return null;


    }
    private long getDaysDiff(Date ago){
        if(ago != null) {
            TimeUnit timeUnit = TimeUnit.DAYS;
            long time = new Date().getTime() - ago.getTime();
            return timeUnit.convert(time, TimeUnit.DAYS);
        }
        return 0;
    }
}
