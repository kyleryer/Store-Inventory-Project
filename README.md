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

### G.  Modify the parts to track maximum and minimum inventory by doing the following:
####  •  Add additional fields to the part entity for maximum and minimum inventory.
####  •  Modify the sample inventory to include the maximum and minimum fields.
####  •  Add to the InhousePartForm and OutsourcedPartForm forms additional text inputs for the inventory so the user can set the maximum and minimum values.
####  •  Rename the file the persistent storage is saved to.
####  •  Modify the code to enforce that the inventory is between or at the minimum and maximum value.

- In Part.java:
  - At lines 31-34, created minInv and maxInv variables and used similar @Min annotation to ensure both values remain at or above 0
  - At lines 44-58, added minInv and maxInv parameters to both constructors
  - At lines 93-99, added getter and setter methods for the minInv and maxInv variables
  - At lines 101-103, created method that determines if inventory value falls within the minimum/maximum inventory range
- In BootStrapData.java:
  - At lines 51-52, 65-66, 79-80, 101-102, and 118-119, set minimum and maximum inventory values for each part in sample inventory
- In InhousePartForm.html:
  - At lines 26-30, added fields for minimum and maximum inventory in the inhouse part form
- In OutsourcedPartForm.html:
  - At lines 25-29, added fields for minimum and maximum inventory in the outsourced part form
- In application.properties:
  - At line 6, renamed the database to controllers-r-us-db
- In AddInhousePartController.java:
  - At lines 43-56, added logic that checks for an inventory value outside the minimum/maximum inventory range and returns an error message if outside of range/invalid value
- In AddOutsourcedPartController.java:
  - At lines 44-57, added logic that checks for an inventory value outside the minimum/maximum inventory range and returns an error message if outside of range/invalid value 

### H.  Add validation for between or at the maximum and minimum fields. The validation must include the following:
#### •  Display error messages for low inventory when adding and updating parts if the inventory is less than the minimum number of parts.
#### •  Display error messages for low inventory when adding and updating products lowers the part inventory below the minimum.
#### •  Display error messages when adding and updating parts if the inventory is greater than the maximum.

- In EnufPartsValidator.java:
  - At lines 37-39, added validation using the isValidInv method from Part.java that checks if adding and updating a product lowers any of the parts' inventory below the minimum
- Error messages for inventory amounts below the minimum or above the maximum were created in part G in AddInhousePartController.java (lines 44-52) and AddOutsourcedPartController.java (lines 45-53)

### I.  Add at least two unit tests for the maximum and minimum fields to the PartTest class in the test package.

- In PartTest.java:
  - At lines 160-176, created two unit tests that tested minimum and maximum inventory values and their getter/setter methods

### J.  Remove the class files for any unused validators in order to clean your code.

- Deleted DeletePartValidator.java (all lines) due to it having 0 usages