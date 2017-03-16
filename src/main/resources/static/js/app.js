(function(){
    var app = angular.module('wordmatch', []);

    app.controller('WordmatchController', ['$http', function($http) {
        var wordmatch = this;
        wordmatch.checkClick = false;
        wordmatch.language = 'english';
        wordmatch.resultLimit = 10;

        wordmatch.words = [];

        this.check = function() {
            for (i = 0; i < wordmatch.words.length; i++) {
                if (wordmatch.words[i].answer === wordmatch.words[i].german) {
                    // word matches!
                }
            }
            this.checkClick = true;
        };

        this.setLanguage = function(language) {
            wordmatch.language = language;
        };

        this.getWord = function(word) {
            if (wordmatch.language === 'german') {
                return word.german;
            } else {
                return word.english;
            }
        };

        this.getValid = function(word) {
            return word.answer === word.german;
        };

        this.hasWords = function() {
            return this.wordmatch.words.length > 0;
        };

        this.getWords = function() {
            $http({
                    method : "GET",
                    url : "/getWords/" + wordmatch.resultLimit
                }).then(function success(response) {
                    wordmatch.words = response.data;
                }, function error(response) {
                    alert("nope");
                });
            this.checkClick = false;
        };

    }]);

    app.controller('PanelController', function() {
        this.tab = 1;
        this.selectTab = function(setTab) {
            this.tab = setTab;
        };
        this.isSelected = function(checkTab) {
            return this.tab === checkTab;
        };
    });

    app.controller('WordAddController', ['$http', function($http) {
        this.word = {
            correct: 0,
            incorrect: 0,
        };

        this.addWord = function() {
            $http({
                method : "POST",
                url : "/addWord",
                data : this.word
                //headers: {'Content-Type': 'application/json'}
                }).then(function success(response) {
                    //wordmatch.words = response.data;
                    alert("success");
                }, function error(response) {
                    alert("nope");
                });
            //words.push(this.word);
            this.word = {
                correct: 0,
                incorrect: 0,
                };
        };
    }]);



})();