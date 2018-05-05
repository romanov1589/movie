var app = angular.module('app', []);
app.controller('AddMovieController', function ($scope, $http, $location, $window) {

    $scope.addMovie = function () {
        var url = "http://localhost:8080/addmovie";
        var data = {
            "title": $scope.title,
            "shortDescription": $scope.shortDescription,
            "ageRating": $scope.ageRating,
            "runningTime": $scope.runningTime,
            "releaseDate": $scope.releaseDate,
            "genre": $scope.genre,
            "director": $scope.director
        };
        $http.post(url, data).then(function () {
            $window.location.href = "/";
        })
            .catch(function () {
                alert("error adding new movie");
            });
    };

});