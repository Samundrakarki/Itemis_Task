# Task 1: Sales Tax

## Description

This is a console application that prints the order of the item given by the user and provides the receipt imposing the tax on each item. Furthermore, the receipt contains price of an item after imposing tax on it, total tax imposed on the order and total price of the order. <br>

```diff
-Note: The name of some methods in test files are really long. I could have used an acronym to make the method 
-name shorter, however, doing so would make test cases more are harder to understand. Furthermore, I have written
-seperate test cases for each branch cases of a method. The test case with same method name but different suffix
-are branch cases of the same method.
```
## Build

To compile and run the project you should install apache maven( @version 3.8.3 is preferred ) and java (@ersion 8 is minimum requirement) in your machine. All of the dependencies and build plugins are defined in <b>pom.xml</b>. <br>
<br>
<b> To execute the code : </b><br>
```
 cd ./SalesTaxSolution
 mvn compile exec:java -Dexec.mainClass="com.itemis.salesTaxApp.SalesTaxApp"
```
<b>To run the test cases : </b><br>

```
mvn test
```

<b> To remove target folder : </b> <br>

```
mvn clean
```

## Assumptions

In this application, we assume that a customer is choose the item, provide the price, quantity and import status of the item. Whether the provided item is basic sales tax applicable or not is not provided by the customer. A demo is shown in the picture below: <br> <br> 
![demoExecution](https://user-images.githubusercontent.com/37009411/138981617-e76b093d-0d0f-4b6b-8b5d-3771ca3458ac.png)
<br><br>
First the customer will be asked if they want to enter the application or quit the application. If the customer provides <b><i>Enter</i></b> as an input to the application, then the application will give the instruction as shown in the picture. A customer can choose any item from the given list. To choose an item, a customer should provide the index of the item from list. As in the picture, the customer entered <b><i>1</i></b> to choose <b><i>Book</i></b>. Now, the customer is asked the quantity of the book they ordered, then price of the item and finally import status. After providing all of the information, the customr can either enter <b><i> 0 </i></b> to get the receipt and leave the application or can still order next item.

```diff
-  Note : You will get Build Failue in case of invalid input. 
- This application is build in such a way that it should strictly throw error when any invalid parameter is passed. 
+  The customer are expected to follow exactly what is stated in the instruction for desired result.
- Incase of invalid input parameter, the application will throw InvalidInputException(custom excpetion class) or IOException.
```

```diff
+Method used to solve the task:
   I used sql class diagarm to get appropriate relationship between classes. Then I write the 
   testcase needed for method that will be used in the class. I feel more comfortable and organized
   in this process.
```
