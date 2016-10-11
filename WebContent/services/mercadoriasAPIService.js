angular.module("controleMercadorias").factory("mercadoriasAPI", function ($http, config){
	var _getMercadorias = function(){
		return $http.get(config.baseURL + "/MercadoriaControl.do");
	};
	var _setMercadoria = function(mercadoria){
		return $http.post(config.baseURL + "/MercadoriaControl.do", mercadoria);
	}
	return {
		getMercadorias : _getMercadorias,
		setMercadoria: _setMercadoria
	};
});