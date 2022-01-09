package io.dxps.knqb;

//import io.quarkus.test.junit.NativeImageTest;
import io.quarkus.test.junit.QuarkusIntegrationTest;

// [i] According to https://quarkus.io/guides/getting-started-testing#native-executable-testing
// QuarkusIntegrationTest should be used instead of NativeImageTest annotation.

//@NativeImageTest
@QuarkusIntegrationTest
public class NativeAccountResourceTest extends AccountResourceTest{

    // With "mvn clean install -Pnative" it will run the existing tests
    // against the generated executable.

}
