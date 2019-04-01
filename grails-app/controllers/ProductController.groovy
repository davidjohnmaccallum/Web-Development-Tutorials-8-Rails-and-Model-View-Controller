class ProductController {

    def display(def params) {

        // Get the product out of the database

        def p = Product.get(params.id)

        if (p == null) {
            // Redirect to a product not found.
            println "Not found";
        }

        // render the display view, passing in the product
        render(view:"display", model: [ product: p ])


    }

    def create(def params) {        
        
        render(view:"create")

    }

    def save(def params) {

        // get the data from the user (HTTP POST data)
        // save data in the database

        def product = new Product(params)

        product.save()

        if (product.hasErrors()) {
            println product.errors
        } else {
            redirect(action:"display", params: [id: product.id])
        }

    }

}