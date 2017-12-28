angular.module('JWTDemoApp')
// Creating the Angular Controller
    .controller('CreateSubjectController', function($http, $scope, AuthService) {
        $scope.user = AuthService.user;
        $scope.buttonText = 'CREATE';

        var init = function(subject) {
            $http.get('api/create-subject').success(function(res) {
                $scope.subjects = res;

                $scope.userForm.$setPristine();
                $scope.message='';
                $scope.subject = subject;
                $scope.buttonText = 'CREATE';
            }).error(function(error) {
                $scope.message = error.message;
            });
        };
        $scope.initEdit = function(subject) {
            $scope.subject = subject;
            $scope.message='';
            $scope.buttonText = 'CREATE';
        };
        var editUser = function(){
            $http.put('api/create-subject', $scope.subject).success(function(res) {
                $scope.subject = null;
                $scope.confirmPassword = null;
                $scope.userForm.$setPristine();
                $scope.message = "Editting Success";
                init();
            }).error(function(error) {
                $scope.message = error.message;
            });
        };
        $scope.submit = function() {
            editUser();
        };
        init();

    });
