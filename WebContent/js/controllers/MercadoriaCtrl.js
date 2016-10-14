angular.module("controleMercadorias").controller("mercadoriaCtrl", function($scope, mercadoriasAPI){
	$scope.app = "controleMercadorias";
	$scope.mercadorias = [];
	$scope.listaParaDeletar = [];
	$scope.erro = [{Hapened: false},{Message: ""}];
	$scope.carregando = false;
	$scope.isMercadoriaSelecionada = function (mercadorias) {
		return mercadorias.some(function (mercadoria) {
			return mercadoria.selecionado;
		})
	}
	var carregarMercadorias = function(){
		$scope.carregando = true;
		mercadoriasAPI.getMercadorias().success(function(data, status){
			$scope.mercadorias = data;
			console.log(data);
			$scope.erro.Hapened = false;
			$scope.erro.Message = "";
			console.log($scope.erro);
			$scope.carregando = false;
		}).error(function(data,status){
			console.log($scope.erro);
			$scope.erro.Hapened = true;
			$scope.erro.Message = "Não foi possivel carregar a lista de mercadorias, erro: " + status;
			$scope.carregando = false;
		});
		
	}
	$scope.adicionarMercadoria = function (mercadoria){
		var _preco = mercadoria.preco.replace(',','.');
		mercadoria.preco = _preco;
		mercadoriasAPI.setMercadoria(mercadoria).success(function(data, status){
			delete $scope.mercadoria;
			$scope.formMercadorias.$setPristine();
			carregarMercadorias();
			$scope.erro.Hapened = false;
			$scope.erro.Message = "";
		}).error(function(data,status){
			$scope.erro.Hapened = true;
			$scope.erro.Message = "Não foi adicionar a mercadoria, erro: " + status;
		});
	};
	$scope.apagarMercadorias = function (mercadorias) {
		$scope.listaParaDeletar = mercadorias.filter(function (mercadoria){
			if (mercadoria.selecionado) return mercadoria;
		});	
		var _lista = $scope.listaParaDeletar;
		mercadoriasAPI.deletarMercadorias(_lista).success(function(data, status){
			$scope.formMercadorias.$setPristine();
			carregarMercadorias();
			$scope.erro.Hapened = false;
			$scope.erro.Message = "";
		}).error(function(data,status){
			$scope.erro.Hapened = true;
			$scope.erro.Message = "Não foi possivel deletar a mercadoria, erro: " + status;
		});
	};
	carregarMercadorias();
});