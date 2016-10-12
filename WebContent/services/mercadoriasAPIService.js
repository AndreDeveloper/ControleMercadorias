angular.module("controleMercadorias").factory("mercadoriasAPI", function ($http, config){
	var _getMercadorias = function(){
		return $http.get(config.baseURL + "/MercadoriaControl.do");
	};
	var _setMercadoria = function(mercadoria){
		return $http.post(config.baseURL + "/MercadoriaControl.do", mercadoria);
	};
	var _deletarMercadorias = function(listaParaDeletar){
		return $http.post(config.baseURL + "/MercadoriaControl.do", listaParaDeletar);
	};
	return {
		getMercadorias : _getMercadorias,
		setMercadoria: _setMercadoria,
		deletarMercadorias: _deletarMercadorias
	};
});