/**
 * Declare MainCtrl, this controller does a GET on "/hello" and put the result in scope.
 */
function MainCtrl($scope, $http ,Object1) {

    $scope.object1s = Object1.all();

    $http.get("/hello").success(function(data) {
        $scope.hello = data.value;
    });

//     $http.get("/object1").success(function(data) {
//            $scope.object1s = data;
//        });

     $scope.insertNewObject1 = function(newObject1) {
        var o1= {field1: newObject1.field1,field2: newObject1.field2,field3: newObject1.field3 }
        $scope.object1s.push(o1);
        Object1.add(o1);
        newObject1.field1="";
        newObject1.field2="";
        newObject1.field3="";
      };

}

/**
 * Declare the routes.
 * Route /main (#/main in browser) use the controller MainCtrl with template main.html
 */
var app=angular.module('spikeSimpleWeb4J', ['ngResource']);

app.config(['$routeProvider', function($routeProvider) {
    $routeProvider.when('/main', {templateUrl:'partial/main.html', controller:MainCtrl});
    $routeProvider.otherwise({redirectTo: '/main'});
}])

app.factory("Object1", function($resource)
{
    var out;
    out= $resource('/object1/:id',
     {
        //Default parameters

      },
      {
         //Actions
          all: {
              method: 'GET',
              isArray: true
            }
          ,
         one: {
             method: 'GET',
             isArray: false
         },
         add: {
             method: 'POST'
         },
         update: {
             method: 'PUT'
         }
     });


     return out;
});



