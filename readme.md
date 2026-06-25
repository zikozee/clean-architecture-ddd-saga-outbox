# base 

- run mvn clean install 
  - to validate no dependency issue

## VISUALIZING ARCHITECTURE OF PROJECT
- visualize project/service structure with Graphviz 
  - installation instruction from - https://graphviz.org/
  - from  https://github.com/ferstl/depgraph-maven-plugin
    - run command mvn com.github.ferstl:depgraph-maven-plugin:aggregate -DcreateImage=true -DreduceEdges=false -Dscope=compile "-Dincludes=com.food.ordering.system*:*"
    - OR simply mvn com.github.ferstl:depgraph-maven-plugin:aggregate -DcreateImage=true -DreduceEdges=false
