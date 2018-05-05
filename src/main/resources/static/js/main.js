var app = angular.module('app', []);

app.controller('MoviesController', function ($scope, $http, $location, $window) {

    $scope.allActors = [];
    $http.get('http://localhost:8080/actors')
        .then(function (response) {
            $scope.allActors = response.data;
            console.log("status:" + response.status);
        }).catch(function (response) {
        console.error('Error occurred:', response.status, response.data);
    }).finally(function () {
        console.log("Task Finished.");
    });

    $scope.movies = [];
    $http.get('http://localhost:8080/movies')
        .then(function (response) {
            $scope.movies = response.data;
            console.log("status:" + response.status);
        }).catch(function (response) {
        console.error('Error occurred:', response.status, response.data);
    }).finally(function () {
        console.log("Task Finished.");
    });

    $scope.viewMovie = function (movie) {
        $scope.description = movie.shortDescription;
        $scope.title = movie.title;
        $scope.agerating = movie.ageRating;
        $scope.runningTime = movie.runningTime;
        $scope.releaseDate = movie.releaseDate;
        $scope.genre = movie.genre;
        $scope.director = movie.director;
        $scope.movieActors = movie.actors;
    };

    $scope.deleteMovie = function (movie) {
        var confirmDeleting = $window.confirm('Are you sure you want to delete this movie?');
        if(confirmDeleting) {
            $http.delete('http://localhost:8080/movies/' + movie.id).then(function () {
                $window.location.href = "/";
            }).catch(function () {
                alert("error")
            })
        }
    };

    $scope.addActorToMovie = function(movie){
        if($scope.selectedActor == null){
            alert("You should choose an actor from Actor\'s List");
        }
        $http.put('http://localhost:8080/movies/' + movie.id + '/' + $scope.selectedActor[0]).then(function () {
            alert("Actord added to movie!");
            $window.location.href = "/";
        }).catch(function () {
            alert("error")
        });
    };

});
