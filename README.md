# ucsd_cse232b_project
A xquery processor for ucsd cse 232b courser project

## Usage
1. package and run mannually
		mvn package
		java -jar target/CSE-232B-M1.jar path/to/single\_query\_xpath.txt path/to/output.xml
2. test
		mvn test
	- current tests:
		- 5 query string from instructor
		- run and compare the content with some standard ones(with some standard versions, maybe 1.0)
		- additional test (6th) test the attrName visitor, only test in stringConstant filter

## Project Design
![Project Design](Docs/Project_Design.png)

### Entry
		java -jar M1.jar single_query_xpath.txt result.xml

### Main
The main interface, give argvs, get output xml file.

### Engine(Visitor)
The engine, put parser tree(AST) into visit method of the engine, get the output DOM nodes.
The Engine itself only implement ap and doc visitor, then using RpEngine to visit rp.

### RpEngine(Visitor)
The subengine, put in rp, get output DOM nodes. 
The RpEngine itself only implement rp visitor, then using FilterEngine to visit f.

### [NEW!] FilterEngine(Visitor)
The subengine, put in filterContext, get the Boolean indicates whether the filter hold at paramNode.

### XMLProcessor
XML-DOM parser and serializer.

## TBD
1. Optimize the implementation the project. (To make sure originality), directions:
	- OOD in Engine
		- principles: <200 line per file, < 20 methods per class
		- modify helpers 
		- remove global variable paramNodes
2. Refactor the project

	- [x] optimize the project structure
		- rename Engine->Main, QEngineVisitor->Engine
		- remove XPathEvaluator and add evaluateXPath into Main
	- modify the XMLProcessor
		- [x] store all the data, instead of DEFAULT
	- additional query
	- Autometically check the answer? (manually is acceptible)
## Misc
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

### [Milestone 1](https://github.com/champion-chenpeng/ucsd_cse232b_xquery/milestone/1)
Due by Feb 7, finish naive xpath evaluator.

