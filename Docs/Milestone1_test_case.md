# Milestone 1 test cases
1. Find all persons in the play: 
-		doc("j_caesar.xml")//PERSONA
2. Find the scenes in which CAESAR speaks 
-		doc("j_caesar.xml")//SCENE[SPEECH/SPEAKER/text() = "CAESAR"]
3. Find the acts containing some scene in which both CAESAR and BRUTUS speak 
-		doc("j_caesar.xml")//ACT[SCENE [SPEECH/SPEAKER/text() = "CAESAR" and SPEECH/SPEAKER/text() = "BRUTUS"]]
4. Same as previous, but different syntax
-		doc("j_caesar.xml")//ACT[SCENE [SPEECH/SPEAKER/text() = "CAESAR"][SPEECH/SPEAKER/text() = "BRUTUS"]]
5. Find the acts in which CAESAR no longer appears 
-		doc("j_caesar.xml")//ACT[not .//SPEAKER/text() = "CAESAR"]
