package plugin;

import io.restassured.RestAssured;
import io.restassured.filter.Filter;
import io.restassured.filter.FilterContext;
import io.restassured.response.Response;
import io.restassured.specification.FilterableRequestSpecification;
import io.restassured.specification.FilterableResponseSpecification;

public class RemoveCharsetFilter implements Filter {
    @Override
    public Response filter(FilterableRequestSpecification requestSpec, FilterableResponseSpecification responseSpec, FilterContext context) {
        System.out.println("requestSpec  "+requestSpec);
        requestSpec.removeHeader("Content-Type"); // Remove Content-Type header completely
        requestSpec.header("Content-Type", "application/vnd.api.v2+json"); // Add a new Content-Type header if needed

        // You can add more logic here to remove specific headers

        // Continue with the request
        return context.next(requestSpec, responseSpec);
    }
}
