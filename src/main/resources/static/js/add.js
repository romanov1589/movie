var app = angular.module('app', []);
app.controller('AddController', function($scope, $http, $location, $window) {
    $scope.addMovie = function(){
        var url = "http://localhost:8080/addmovie";
        var data = {
            "title": $scope.title,
            "shortDescription": $scope.shortDescription,
            "ageRating": $scope.ageRating
        };
        $http.post(url, data).then(function(data){
            $scope.title = "";
            $scope.shortDescription = "";
            $scope.ageRating = "";
            $window.location.href="/";
        })
            .catch(function(data){
                alert("error");
            });
    }
});