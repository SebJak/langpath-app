app.controller('WordGroupListCtrl', function ($scope) {
    $scope.groups = [
        {
            id: 1,
            name: 'Der erste Satz.',
            description: 'Eine Probe Reihe von Wörtern',
            sourceLang: 'German',
            targetLang: 'Polish',
            countWords: 25
        },
        {
            id: 2,
            name: 'La prima serie.',
            description: 'Un campione insieme di parole.',
            sourceLang: 'Italian',
            targetLang: 'Polish',
            countWords: 14
        },
        {
            id: 3,
            name: 'El primer set.',
            description: 'Una muestra de un conjunto de palabras.',
            sourceLang: 'Spanish',
            targetLang: 'Polish',
            countWords: 16
        },
        {
            id: 4,
            name: 'Pierwszy zestaw',
            description: 'Przykładowy zestaw słów.',
            sourceLang: 'Polish',
            targetLang: 'English',
            countWords: 18
        },
    ];
    $scope.remove = function (groupId) {
        //removing wordGroup
    };

})