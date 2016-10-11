angular.module("controleMercadorias").controller("mercadoriaCtrl", function($scope, mercadoriasAPI){
	$scope.app = "controleMercadorias";
	$scope.mercadorias = [];
	$scope.isMercadoriaSelecionada = function (mercadorias) {
		return mercadorias.some(function (mercadoria) {
			return mercadoria.selecionado;
		})
	}
	var carregarMercadorias = function(){
		mercadoriasAPI.getMercadorias().success(function(data, status){
			$scope.mercadorias = data;
			console.log(data);
		}).error(function(data,status){
		
		});
	}
	$scope.adicionarMercadoria = function (mercadoria){
		mercadoriasAPI.setMercadoria(mercadoria).success(function(data, status){
			delete $scope.mercadoria;
			$scope.formMercadorias.$setPristine();
			carregarMercadorias();
		}).error(function(data,status){

		});
	};
	
	carregarMercadorias();
});