
app.controller('WordGroupCtrl', function ($scope) {

    $scope.wordGroup = {
        name: "Example Word group.",
        author: "Sebastian Jakowski",
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
    }
    console.log("Welcome WordGroupCtrl");

});
