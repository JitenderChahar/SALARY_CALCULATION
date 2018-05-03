'use strict'
var module = angular.module('demo.controllers', []);
module.controller("EmployeeController", [ "$scope", "EmployeeService",
		function($scope, EmployeeService) {
			EmployeeService.getAllEmployees().then(function(value) {
				$scope.allEmployees = value.data;
			}, function(reason) {
				console.log("error occured");
			}, function(value) {
				console.log("no callback");
			});

			$scope.getSalary = function(empId) {
				EmployeeService.getEmployeeSalary(empId).then(function(value) {
					$scope.salary = value.data;
				}, function(reason) {
					console.log("error occured");
				}, function(value) {
					console.log("no callback");
				});
			}
		} ]);