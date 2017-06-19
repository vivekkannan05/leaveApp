(function(){
    var app = angular.module("leaveApp");
    app.controller("headerLeaveAppCtrl",headerLeaveAppCtrl);
    function headerLeaveAppCtrl(LeaveAppNameSvc){
        this.appname=LeaveAppNameSvc;
    }
})();