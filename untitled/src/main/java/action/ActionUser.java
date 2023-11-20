package action;


import beans.Usuario;
import com.google.gson.Gson;
import dao.DAOUser;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

public class ActionUser {
    DAOUser daoUser;
    public String execute(HttpServletRequest request, HttpServletResponse response){
        String answer = "";

        String action = request.getParameter("ACTION");
        String[] method = action.split("\\.");

        switch (method[1]){
            case "LOGIN":
                answer = login(request, response);
                break;
            default:
                System.out.println("wtf why am i here");
                break;
        }



        return answer;
    }

    private String login(HttpServletRequest request, HttpServletResponse response) {
        Usuario usuario = new Usuario();
        usuario.setUsername(request.getParameter("username"));
        usuario.setPassword(request.getParameter("password"));
        ArrayList<Usuario> listUsuario = new DAOUser().findAll(usuario);
        String jsonUsuario = "";
        Gson gson = new Gson();
        jsonUsuario += "{\"message\": \"Esto es un mensaje de ejemplo\"," +
                "\"usersList\": [";
        if (!listUsuario.isEmpty()){
            jsonUsuario += gson.toJson(listUsuario.get(0));
        }
        jsonUsuario += "]}";

        return jsonUsuario;
    }
}
