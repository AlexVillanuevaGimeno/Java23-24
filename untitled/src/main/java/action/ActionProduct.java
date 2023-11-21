package action;

import beans.Product;
import dao.DAOProduct;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

public class ActionProduct {
    DAOProduct daoProduct;

    public ActionProduct(){
        daoProduct = new DAOProduct();
    }

    public String execute(HttpServletRequest request, HttpServletResponse response){
        String answer = "";

        String action = request.getParameter("ACTION");
        String[] method = action.split("\\.");

        switch(method[1]){
            case "ADD":
                System.out.println("Action: Añadir?");
                answer = addProduct(request, response);
                break;
            case "LST":
                System.out.println("Action: Listo Productos");

            default:
                System.out.println("default Action");
                break;
        }
        return answer;
    }

    /**
     * constructor
     *  this.idProducto = idProducto;
     *         this.nombreProducto = nombreProducto;
     *         this.precioProducto = precioProducto;
     *         this.marcaProducto = marcaProducto;
     *         this.fechaSubidaProducto = fechaSubidaProducto;
     *         this.descripcionProducto = descripcionProducto;
     *         this.imagenProducto = imagenProducto;
     *         this.idUsuario = idUsuario;
     *
     *         /*String jsonResponseObject= "{\n" +
     *                 "    \"message\": \"Este es un mensaje de ejemplo\",\n" +
     *                 "    \"productList\": [\n" +
     *                 "        {\n" +
     *                 "            \"username\": \"username1\",\n" +
     *                 "            \"token\": \"token1\"\n" +
     *                 "        },\n" +
     *                 "        {\n" +
     *                 "            \"username\": \"username2\",\n" +
     *                 "            \"token\": \"token2\"\n" +
     *                 "        },\n" +
     *                 "        {\n" +
     *                 "            \"username\": \"username3\",\n" +
     *                 "            \"token\": \"token3\"\n" +
     *                 "        }\n" +
     *                 "    ]\n" +
     *                 "}";
     *
     * @param request
     * @param response
     * @return
     */
    private String addProduct(HttpServletRequest request, HttpServletResponse response) {
        int idProducto = Integer.parseInt(request.getParameter("Id_Producto"));
        String nombreProducto = request.getParameter("Nombre_Producto");
        double precioProducto = Double.parseDouble(request.getParameter("Precio_Producto"));
        String marcaProducto = request.getParameter("Marca_Producto");
        String fechaSubidaProducto = request.getParameter("Fecha_Subida_Producto");
        String descripcionProducto = request.getParameter("Descripcion_Producto");
//        String categoria = request.getParameter("categoria");
        String imagenProducto = request.getParameter("Imagen_Producto");
        int idUser = Integer.parseInt(request.getParameter("Id_Usuario"));

        Product product = new Product(idProducto,nombreProducto,precioProducto,marcaProducto,fechaSubidaProducto,descripcionProducto,imagenProducto,idUser);
        daoProduct.add(product);
        return "";
    }
}
