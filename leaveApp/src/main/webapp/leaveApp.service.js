(function () {
    var app = angular.module("leaveApp");
    app.service("LeaveAppDataSVC", function ($http,$q) {
        var self = this;
        self.fetchAllEmployee = function (){
            var promise1 = $http.get('http://localhost:9091/emp');
            var promise2=promise1.then(function(response) {
                return response.data;
            });
            return promise2;
        }

        self.getEmployee = function (email) {
        	console.log(email);
        	$http.get('http://localhost:9091/emp/' + email).then(function (response) {
        		return response.data;
        	}, function () {
        		console.error('Error');
        	})
        	
        	
        	var deferred = $q.defer(),applicationDataResponse;
        	
        	var url = 'http://localhost:9091/emp/'+email;
        	console.log(url);
            $http.get(url).then(
            		function (applicationDataResponse) {
                deferred.resolve(applicationDataResponse.data);
              },function(applicationDataResponse){
            	  deferred.reject(applicationDataResponse.data);
              });
            return deferred.promise;
        }
        
        self.getRequestList=function(emp){
        	var promise4=$http.get('http://localhost:9091/leaveReq/'+emp.id).then(function(response){
        		return response.data;
        	});
        	return promise4;
        }
        
        self.applyLeave=function(leaveReq){
        var promise5= $http.post('http://localhost:9091/leaveReq',leaveReq).then(
        		function(response){
        			return response.data
        		});
        return promise5;
        }

    });
})();