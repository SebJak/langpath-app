/**
 * Created by root on 17.10.16.
 */

app.controller('LearnWordGroupCtrl', function ($scope) {
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

    $scope.currentWord = getNextWord();


    $scope.messages = [];
    $scope.answer = '';
    $scope.lastWrongAnswer= {};

    $scope.checkAnswer = function () {
        console.log("Answer is checking ....");
        if($scope.answer !== undefined && $scope.answer.toLowerCase() === $scope.currentWord.meaning.toLowerCase()) {
            //$scope.wordGroup.words.word.goodAnswers+=1;
            $scope.messages[0] = {type: "INFO", value: "Correct answer"};
            //$scope.wordGroup.words[word].toRepeat-=1;
        }
        else {
            $scope.lastWrongAnswer = $scope.currentWord;
            $scope.messages[0]={type: "ERROR", value: "Wrong answer, correct answer should be: "};
            //$scope.wordGroup.words.word.wrongAnswers+=1;
            //$scope.wordGroup.words.word.toRepeat+=1;
        }
        $scope.currentWord = getNextWord();
        $scope.answer = '';
    };

    $scope.init = function (){
        $http({
            method: 'POST',
            url: '/langpath/query/login',
            data: $scope.credentials,
            headers: {'Content-Type': 'application/x-www-form-urlencoded'}
        }).then(function (response) {
            if(response.status == 200 && response.data.token != undefined) {
                SessionService.setAuthentication(response.data);
                $window.location.href = '#weclome';
            }
        });
    }

    function getNextWord() {
        while($scope.wordGroup.words.length > 0) {
            var index = Math.floor(Math.random() * $scope.wordGroup.words.length);
            return $scope.wordGroup.words[index];

        }
    }

    $(document).ready(function(){
        $('#answer').keypress(function(e){
            if(e.keyCode==13)
                $('#checkAnswerButton').click();
        });
    });


});

