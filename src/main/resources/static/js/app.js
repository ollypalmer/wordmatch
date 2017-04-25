(function(){
    var app = angular.module('wordmatch', []);

    app.controller('WordmatchController', ['$http', function($http) {
        var wordmatch = this;
        wordmatch.checkClick = false;
        wordmatch.language = 'english';
        wordmatch.resultLimit = 10;
        wordmatch.difficulty = 'getWords';

        wordmatch.words = [];

        this.check = function() {
            for (i = 0; i < wordmatch.words.length; i++) {
                if ((wordmatch.words[i].answer === wordmatch.words[i].english && wordmatch.language === 'german') ||
                    (wordmatch.words[i].answer === wordmatch.words[i].german && wordmatch.language === 'english')) {
                    $http({
                            method : "GET",
                            url : "/updateCorrect/" + wordmatch.words[i].id
                        }).then(function success(response) {
                            //nothing here...
                        }, function error(response) {

                        });
                } else {
                    $http({
                            method : "GET",
                            url : "/updateIncorrect/" + wordmatch.words[i].id
                        }).then(function success(response) {
                            //nothing here..
                        }, function error(response) {

                        });
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
            if (wordmatch.language === 'german') {
                return word.answer === word.english;
            } else {
                return word.answer === word.german
            }
        };

        this.hasWords = function() {
            return this.wordmatch.words.length > 0;
        };

        this.getWords = function() {
            $http({
                    method : "GET",
                    url : "/" + wordmatch.difficulty + "/" + wordmatch.resultLimit
                }).then(function success(response) {
                    wordmatch.words = response.data;
                }, function error(response) {

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

    app.controller('OptionsController', ['$http', function($http) {
        var options = this;
        options.words = [];

        this.getWords = function() {
            $http({
                method : "GET",
                url : "/getAll"
            }).then(function success(response) {
                options.words = response.data;
            }, function error(response) {
                //error
            });
        };

        this.removeWord = function(word) {
            $http({
               method : "DELETE",
               url : "/delete/" + word.id
            }).then(function success(response) {

            }, function error(response) {
               //error
            });
            options.getWords();
        };


        options.getWords();
    }]);



})();
