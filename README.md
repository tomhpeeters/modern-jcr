# A Modern API to use JCR with Streams

## License

The source code is licensed under the [Apache License, Version 2.0](http://www.apache.org/licenses/LICENSE-2.0).

## Java

This library requires Java 8 or up.

## Usage

1. Add dependency to your project (For example maven:)
```
<dependency>
    <groupId>com.github.zwaldeck</groupId>
    <artifactId>modernjcr</artifactId>
    <version>1.0.0</version>
</dependency>
```
2. Convert NodeIterator to a Stream and use it (Listing all nodes of a certain type)
```
Node rootNode = jcrSession.getRootNode();
ModernJcr.asStream(rootNode.getNodes())
                .filter(node -> node.getPrimaryNodeType().isNodeType("sling:folder"))
                .forEach(node -> System.out.println("Name: " + node.getName()));

```

## Resources

- Javadoc
- Build status