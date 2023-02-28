package ucode.outdoorshoppingproduct;

import java.time.Instant;
import java.util.List;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Document(indexName = "product_index")
public class Product {
  private @Id String id;
  private @Field(type = FieldType.Text) String name;
  private @Field(type = FieldType.Text) String description;
  private @Field(type = FieldType.Integer) int price;
  private List<String> keywords;
  private @CreatedDate @Field(type = FieldType.Date, name = "created_at") Instant createdAt;
}
