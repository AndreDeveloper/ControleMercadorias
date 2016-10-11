package br.com.desafiovalemobi.control;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import br.com.desafiovalemobi.infrastructure.DAO;
import br.com.desafiovalemobi.infrastructure.MercadoriaDAO;
import br.com.desafiovalemobi.model.Mercadoria;

@WebServlet("/MercadoriaControl.do")
public class MercadoriaControl extends HttpServlet {
	private static DAO dao;
	private static final long serialVersionUID = 1L;

    public MercadoriaControl() {
    	super();
    	dao = MercadoriaDAO.getInstance();	
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		List<Mercadoria> mercadorias = dao.selectAll();
	
		String json = new Gson().toJson(mercadorias);
        response.setContentType("application/json");
        response.getWriter().write(json);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BufferedReader reader = request.getReader();
		StringBuffer json = new StringBuffer();
		String linha = "";
		while ((linha = reader.readLine()) != null){
			json.append(linha);
		}
		Mercadoria mercadoria = new Gson().fromJson(json.toString(), Mercadoria.class);
		if (mercadoria!=null){
			dao.insert(mercadoria);
		}
	}

}