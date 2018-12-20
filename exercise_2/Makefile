# Input Java files (components).
JAVA_FILES=Node.java BinaryTree.java Main.java
# Aspect in AspectJ language.
AJ_ASPECT=Aspect1.aj

ASPECTJRT=/home/petrospant/aspectj/aspect_j/lib/aspectjrt.jar

justJavaCompile: ${JAVA_FILES}
	@javac -cp ${ASPECTJRT} ${JAVA_FILES}

justJavaRun: justJavaCompile
	@echo "== Running without AspectJ =="
	@java Main

aspectJCompile: ${JAVA_FILES} ${AJ_ASPECT}
	@ajc -source 1.8 ${JAVA_FILES} ${AJ_ASPECT}

aspectJRun: aspectJCompile
	@echo "== Running with AspectJ =="
	@java -cp ${ASPECTJRT}:. Main

clean: 
	rm *.class
