# DUTF(a Dynamic Unicode Transformation Format)

This is the working area for the individual Internet-Draft, "draft-yaoyang-dutf".

* [Datatracker Page](https://datatracker.ietf.org/doc/draft-yaoyang-dutf)
* [Individual Draft](https://datatracker.ietf.org/doc/html/draft-yaoyang-dutf)

## Usage

```java
import com.yaoyang.dutf.DUTF;

class DUTFTest {
    
    public static void main(String[] args) {
        String sourceString = "your string to be encoded";
        byte[] bytes = DUTF.encode(sourceString);
        String decodedString = DUTF.decode(bytes);
        System.out.println(decodedString);
    }
}

```