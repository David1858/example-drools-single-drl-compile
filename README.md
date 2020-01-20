# Drools – Compile a Single DRL

## Overview
In projects with many rules (or a slow PC), compiling all DRLs to verify the syntax of rules within a single DRL is an inefficient use of developer time.  This example provides an approach to avoiding this issue.

## Background
The Eclipse plug-in for Drools is helpful when authoring rules.  The plug-in provides keyword highlighting and limited content assistance capabilities.

![image](/images/eclipse-drools-plugin.png)
 
A significant limitation of the plug-in is that it does not highlight syntax errors as Eclipse does for Java code.  In the below example, the plug-in is installed and providing keyword highlighting but it does not identify the obvious error where the rule developer entered a single equal (“=”) rather than the required two equals (“==”).
 
![image](/images/example-rule-with-error.png)
 
Because the plug-in does not highlight syntax issues, these types of simple errors are common when authoring rules.  When “common” is combined with large project that requires 30 or more seconds to compile, the rule developer’s productivity is reduced.

## Time Savings
To demonstrate the time savings, this project has a large decision table with 15,000 rules that determine if a medical claim is eligible for payment based upon the Policy Type and the ICD-10 code.  In addition to the decision table, there is a drl with a rule that has an error.

Within this example project, the rule author must wait over 30 seconds to receive an error that there is a syntax error in the rule.

![image](/images/all-junits.png)
 
To reduce the compile time (and increase rule developer productivity), a simple junit that compiles only the drl under construction is used.  An example of this is [LimitedDrlCompileTest.java](https://github.com/David1858/example-drools-single-drl-compile/blob/master/src/test/java/org/example/LimitedDrlCompileTest.java).
 
Then execute this when you are working within the drl.  It requires only a second or two to compile and identify the syntax issue.
 
![image](/images/single-drl-compile-with-error.png)

![image](/images/error.png)
 
Once the error is correct, it only takes a few seconds to run the test again to confirm.  Then all JUnits can be executed, which requires the 30 or so seconds.

## Conclusion
A simple helper test can be leverage to increase productivity authoring rules.

## References

## Related Articles
