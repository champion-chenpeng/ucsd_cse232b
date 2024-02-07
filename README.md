# ucsd_cse232b_project
A xquery processor for ucsd cse 232b courser project

## Usage
	mvn package
	java -jar target/CSE-232B-M1.jar path/to/single\_query\_xpath.txt path/to/output.xml

## Project file structure
1. Docs: contains first hand from ucsd cse 232b course or helpful notes of collaborator
2. Maven java project structure
	- src
		- main
			- antlr
			- java
				- Main(Interface for use or test)
				- Engine(The XPath visitor, main functional class)
				- XMLProcessor(Contains the DOM-XML parser and serializer, maybe integrated into Main?)
			- resources
				- j_caesar.xml
		- test
			- resources
				- XPath0.txt
				- XPath0_result.xml
	- target(This folder will be hidden according to gitignore)
		- CSE-232B-M1.jar

## [Milestone 1](https://github.com/champion-chenpeng/ucsd_cse232b_xquery/milestone/1)
Due by Feb 7, finish naive xpath evaluator.

### Finished
1. Test 5 query from instructor
	- run under root dir
		- 		mvn test
	- current tests:
		- SingleQueryTest: test one-line input file query without content check
		- ContentCompareTest: compare the query result of current version with a stable version, currently just compare the text, further can compare the DOM tree. (But with same JAXP API, the same DOM tree lead to same XML)
		- intermediate files are stored in target/test-classes

### TBD
1. Refactor the project
	- [x] optimize the project structure
		- rename Engine->Main, QEngineVisitor->Engine
		- remove XPathEvaluator and add evaluateXPath into Main
	- modify the XMLProcessor
		- [x] store all the data, instead of DEFAULT
	- additional query
	- Autometically check the answer? (manually is acceptible)

### Project Architecture
![Project Architecture](Docs/Project_Architecture.png)
#### Pink parts - to be implement
1. Engine: the key part of the project. Instruction says we just need to convert the pseudo-code in the [semantics specification](Docs/Milestone12_xpath_semantics.pdf).
2. Grammar: according to ANTLR 4, we need a .g4 file to describe the grammar of XQuery(XPath for milestome 1) and convert it to a XQuery Parser. Also refer to [semantics specification](Docs/Milestone12_xpath_semantics.pdf).
3. XML-DOM parser and DOM-XML serializer: using JAXP(Java API for XML Processing) to finish these two parts(several lines of code). Please refer to related Java documents.
#### Other parts
1. Yellow parts: input (files)
2. Orange parts: (intermediate) output (files)
3. Green parts: 3rd party tools
4. Blue parts: output program

### Project Design
![Project Design](Docs/Project_Design.png)

#### Entry
		java -jar M1.jar single_query_xpath.txt result.xml

#### Main
The main interface, give argvs, get output xml file.

#### Engine(Visitor)
The engine, put parser tree(AST) into visit method of the engine, get the output DOM nodes.

#### XMLProcessor
XML-DOM parser and serializer.
