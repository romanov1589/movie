var app = angular.module('app', []);
app.controller('AddActorController', function($scope, $http, $location, $window) {
    $scope.addActor = function(){
        var url = "http://localhost:8080/addactor";
        var data = {
            "firstName": $scope.firstName,
            "lastName": $scope.lastName,
        };
        $http.post(url, data).then(function(){
            $scope.firstName = "";
            $scope.lastName = "";
            $window.location.href="/";
        })
            .catch(function(){
                alert("error");
            });
    }
});