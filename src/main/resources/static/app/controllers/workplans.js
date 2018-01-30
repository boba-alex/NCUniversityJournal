angular.module('JWTDemoApp')
// Creating the Angular Controller
    .controller('WorkPlansController', function($http, $scope, AuthService) {
        $scope.user = AuthService.user;
        $scope.buttonText = 'CREATE';

        var init = function(workPlan) {
            $http.get('api/workplans').success(function(res) {
                $scope.workPlans = res;

                $scope.userForm.$setPristine();
                $scope.message='';
                $scope.workPlan = workPlan;
                $scope.buttonText = 'CREATE';
            }).error(function(error) {
                $scope.message = error.message;
            });
        };
        $scope.initEdit = function(workPlan) {
            $scope.workPlan = workPlan;
            $scope.message='';
            $scope.buttonText = 'CREATE';
        };
        $scope.submit = function() {
        };
        init();

    });
