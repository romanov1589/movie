var app = angular.module('app', []);
app.controller('AddController', function($scope, $http, $location, $window) {

    $scope.actors = [];
    $http.get('http://localhost:8080/actors')
        .then(function (response) {
            $scope.actors = response.data;
            console.log("status:" + response.status);
        }).catch(function (response) {
        console.error('Error occurred:', response.status, response.data);
    }).finally(function () {
        console.log("Task Finished.");
    });

    $scope.addMovie = function(){
        var url = "http://localhost:8080/addmovie";
        var data = {
            "title": $scope.title,
            "shortDescription": $scope.shortDescription,
            "ageRating": $scope.ageRating,
            "runningTime": $scope.runningTime,
            "releaseDate": $scope.releaseDate,
            "genre": $scope.genre,
            "director": $scope.director,
        };
        $http.post(url, data).then(function(){
            $window.location.href="/";
        })
            .catch(function(){
                alert("error");
            });
    };

});