package ucode.outdoorshoppingproduct;

import java.util.List;

/**
 * ProductRequest
 */
public record ProductRequest(String name, String description, int price, List<String> keywords) {
}
