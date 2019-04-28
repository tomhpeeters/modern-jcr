# A Modern API to use JCR with Streams

[![Build Status](https://travis-ci.org/zwaldeck/modern-jcr.svg?branch=master)](https://travis-ci.org/zwaldeck/modern-jcr)
[![Codacy Badge](https://api.codacy.com/project/badge/Grade/37a2aec520d34c03923b5b544c25405d)](https://www.codacy.com/app/zwaldeck/modern-jcr?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=zwaldeck/modern-jcr&amp;utm_campaign=Badge_Grade)
[![Coverage Status](https://coveralls.io/repos/github/zwaldeck/modern-jcr/badge.svg)](https://coveralls.io/github/zwaldeck/modern-jcr)
[![Javadocs](https://www.javadoc.io/badge/com.github.zwaldeck/modernjcr.svg?color=orange)](https://www.javadoc.io/doc/com.github.zwaldeck/modernjcr)
[![License](https://img.shields.io/badge/License-Apache%202.0-yellowgreen.svg)](https://opensource.org/licenses/Apache-2.0)
[![Download](https://api.bintray.com/packages/zwaldeck/Modern-JCR/modern-jcr/images/download.svg) ](https://bintray.com/zwaldeck/Modern-JCR/modern-jcr/_latestVersion)

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
    <version>1.0.1</version>
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

- Javadoc: https://www.javadoc.io/doc/com.github.zwaldeck/modernjcr