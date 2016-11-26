package com.langpath.app.validator;

import com.google.inject.Inject;
import com.langpath.app.model.storage.WordGroup;
import org.apache.log4j.Logger;

import static org.apache.commons.lang3.StringUtils.isNoneBlank;

public class WordGroupValidator implements Validation<WordGroup> {

    @Inject
    private Logger logger;

    @Override
    public boolean validate(WordGroup input) {
        logger.info("Validate input word group.");
        try {
            if (input != null) {
                if (input.getSourceLang().getId() != 0 && input.getTargetLang().getId() != 0
                        && input.getSourceLang().getId() != input.getTargetLang().getId()
                        && isNoneBlank(input.getName()))
                    return true;
            }
        }
        catch (Exception ex) {
            logger.error("During validation word group something was crashed. ", ex);
        }
        return false;
    }
}
