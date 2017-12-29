angular.module('JWTDemoApp')
// Creating the Angular Controller
    .controller('AddWorkPlanController', function($http, $scope, AuthService) {
        $scope.user = AuthService.user;
        $scope.buttonText = 'CREATE';

        var init = function(workPlan) {
            $http.get('api/add-workplan').success(function(res) {
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
        var editUser = function(){
            $http.put('api/add-workplan', $scope.workPlanModel).success(function(res) {
                $scope.workPlanModel = null;
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
