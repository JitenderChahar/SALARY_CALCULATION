'use strict'
var demoApp = angular.module('demo', [ 'ui.bootstrap', 'demo.controllers',
		'demo.services' ]);

demoApp.constant("CONSTANTS", {
	getAllEmployees : "/springboot-hsbc/v1/employees"
});