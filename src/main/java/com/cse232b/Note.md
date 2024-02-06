# rxcay notes
Engine
	main
		xPathEvaluate(xPathFilePath)->
		writeResultToFile(.)
	xPathEvaluate
		evaluateXPathWithoutExceptionPrintErr

XPathEvaluator
	evaluateXPathWithoutExceptionPrintErr
		evaluateXPath(inputStream)
	
	evaluateXPath
		paser = XPathParser(input)
		visitor = QEngineXPathVisitor()
		res = visitor.visit(parser.ap());
			visitor:
				AbstractParseTreeVisitor.visit(ParseTree) -> T
			visitSingleAP or DoubleAP

QEngineXPathVisitor
	visitAp
		visitDoc(ctx.doc());
			XMLProcessor.checkFileNameAndGetNodes()
		setPNodes(resDoc); -> store current n in paramnodes

XMLProcessor
	checkFileNameAndGetNodes
		if DEFAULT == xmlFilename
			loadDefault...
				loadXMLtoDOM
	
