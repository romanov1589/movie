var app = angular.module('app', []);

app.controller('MoviesController', function($scope, $http, $location){
    $scope.movies = [];
    $http.get('http://localhost:8080/movies')
        .then(function (response){
            $scope.movies = response.data;
            console.log("status:" + response.status);
        }).catch(function(response) {
        console.error('Error occurred:', response.status, response.data);
    }).finally(function() {
        console.log("Task Finished.");
    }),

        $scope.viewMovie = function (movie) {
            $scope.description = movie.shortDescription;
            $scope.title = movie.title;
            $scope.agerating = movie.ageRating;
        };

    // $scope.viewMovie = function(movie){
    //     $scope.movie = [];
    //     $http.get('http://localhost:8080/movies/' + movie).then(function (response) {
    //         $scope.movie = response.data;
    //     })
    // }


});
