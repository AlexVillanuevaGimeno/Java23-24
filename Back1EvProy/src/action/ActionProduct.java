package action;

import bean.Product;
import motor.MotorDerby;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

public class ActionProduct {
    MotorDerby motorDerby;

    public ActionProduct() {
        motorDerby = new MotorDerby();
    }

    public String execute(HttpServletRequest request, HttpServletResponse response){
        String answer = "";
        String action = request.getParameter("action");
        String[] method = action.split("\\.");
        System.out.println(method[1]);
        switch(method[1]){
//            case "REGISTER":
//                register(request, response);
//                answer = "TODO: make register return something ig";
//                break;
//            case "FILTER":
//                System.out.println("VAMO A FILTRAH");
//                answer = filter(request, response);
//                break;
        }
        return answer;
    }

//    private String filter(HttpServletRequest request, HttpServletResponse response){
//        Product product = new Product();
//        product.setCategoria(request.getParameter("category"));
//        System.out.println(product.toString());
//        ArrayList<Product> productList = new ArrayList<>();
//        productList = new DaoProduct().findAll(product);
//        if (!productList.isEmpty()) {
//            System.out.println("am i getting here");
//            Gson gson = new Gson();
//            String json = gson.toJson(productList);
//            out.print(json);
//            return json;
//        }
//        return "nothin";
//    }

}
