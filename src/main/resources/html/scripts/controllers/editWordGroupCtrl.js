app.controller('EditWordGroupCtrl', function ($scope) {

    $scope.wordGroup= {};

    $scope.langs =[
        {id: 1,
            label: "English"},
        {id: 2,
            label: "Polish"}
    ];

    $scope.getWordGroup = function () {
        $scope.wordGroup = {
            name: "Example Word group.",
            description: "Example words prepared fo tests",
            sourceLang: {
                id: 1,
                label: "English"
            },
            targetLang: {
                id: 2,
                label: "Polish"
            },
            words: [
                {
                    value: "create",
                    meaning: "tworzyć"
                },
                {
                    value: "cancel",
                    meaning: "anulować"
                },
                {
                    value: "change",
                    meaning: "zmieniać"
                },
                {
                    value: "word",
                    meaning: "słowo"
                },
                {
                    value: "interested in",
                    meaning: "interesować się czymś"
                },
                {
                    value: "value",
                    meaning: "wartość"
                },
            ]
        };

        //here we need call service to take the wordGroup for editing.
    }

    $scope.getWordGroup();

});