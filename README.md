# WESTERN GOVERNORS UNIVERSITY 
## D287 – JAVA FRAMEWORKS

### C.  Customize the HTML user interface for your customer’s application. The user interface should include the shop name, the product names, and the names of the parts.

- The following changes were all made in mainscreen.html:
  - At line 14, changed the webpage title to "Controllers R Us"
  - At line 19, changed the page header to "Controllers R Us"
  - At line 21, changed the Parts header to "Controller Parts"
  - At line 53, changed the Products header to "Controller Types"

### D.  Add an “About” page to the application to describe your chosen customer’s company to web viewers and include navigation to and from the “About” page and the main screen.

- Created about.html file and all lines were written to create the content for the "About" page
- Created AboutController.java and all lines were written to map the /about URL to corresponding about.html template
- Added new line at line 20 in mainscreen.html that added an "About Us" button that allows for navigation to the "About" page from the main screen

### E.  Add a sample inventory appropriate for your chosen store to the application. You should have five parts and five products in your sample inventory and should not overwrite existing data in the database.

- The following changes were all made in BootStrapData.java:
  - At line 3, imported InhousePart class
  - At line 29, defined an InhousePartRepository object
  - At line 42, added an if statement that prevents overwriting data in the database by only allowing inventory to be added if the product and parts repositories are empty (equal to 0)
  - At lines 44-85, created 3 inhouse parts utilizing setter methods to add each of their data and passed these parts to the InhousePartRepository object
  - At lines 87-122, created 2 outsourced parts in the same manner as the inhouse parts and passed these parts to a OuthousePartRepository object
  - At lines 124-134, created 5 products using constructors and added them to product repository

### F.  Add a “Buy Now” button to your product list. Your “Buy Now” button must meet each of the following parameters:
####   •  The “Buy Now” button must be next to the buttons that update and delete products.
####   •  The button should decrement the inventory of that product by one. It should not affect the inventory of any of the associated parts.
####  •  Display a message that indicates the success or failure of a purchase.

- In mainscreen.html:
  - At line 83, added a Buy Now button that appears before the Update and Delete buttons
- Created BuyProductController.java and all lines were written to handle the logic behind the Buy Now button. If product exists and has an inventory greater than 0, the product's inventory will decrement by 1 and will route to a purchase success page. If product is not in stock or doesn't exist, will route to a purchase failed page
- Created buyProductSuccess.html template and all lines were written to display message that a product purchase was successful
- Created buyProductFailed.html template and all lines were written to display message that a product purchase failed