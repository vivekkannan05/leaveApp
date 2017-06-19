(function () {
    var app = angular.module("leaveApp");
    app.controller("leaveAppCtrl", leaveAppCtrl);

    function leaveAppCtrl(LeaveAppDataSVC) {
        var self = this;
        
       /* LeaveAppDataSVC.fetchAllEmployee().then(function (data) {
              self.employeeList = data;
          })*/

        this.getEmployee = function () {
        	
        	console.log(this.email);
        	LeaveAppDataSVC.getEmployee(this.email).then(function (data) {
                self.employeeDetail = data;
            })
            if(null==self.employeeDetail){
            	self.errorMsg="Could not find the details for the Input given";
            	return;
            }
        	self.showFlag=false;
        	self.errorMsg = undefined;
        	self.successMsg= undefined;
            console.log("the output is");
            console.log(self.employeeDetail);
            self.leaveReq={
            		"employee":self.employeeDetail
            };
           LeaveAppDataSVC.getRequestList(self.employeeDetail).then(function(data){
            	self.requestList=data;
            })
            showFlag=true;
        }
        
        
        this.applyLeave=function(){
        	self.errorMsg = undefined;
        	self.successMsg= undefined;
        	console.log(self.leaveReq);
        	var date1= self.leaveReq.startDate;
        	var date2=self.leaveReq.endDate;
        	if(null==date1){
        		self.errorMsg="Select the Start Date";
        		return;
        	}
        	if(null==date2){
        		self.errorMsg="Select the End Date";
        		return;
        	}
        	var diff= date2.getDate()-date1.getDate()+1;
        	if(diff<=0){
        		self.errorMsg="The END Date should be equal or greater than Start Date";
        		return;
        	}
        	console.log(diff);
        	self.leaveReq.employee.availableLeaves-=diff;
        	self.leaveReq.duration=diff;
        	LeaveAppDataSVC.applyLeave(self.leaveReq).then(function(data){
            	self.requestList=data;
            },function(){
        		self.successMsg="Leave Request Added successfully";
        	},function(){
        		self.errorMsg="Error while creating leave request";
        	})
        	self.employeeDetail=self.leaveReq.employee;
        }
          
        

    }
})();