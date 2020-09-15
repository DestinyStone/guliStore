package esbean;

import bean.PmsSkuAttrValue;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import javax.persistence.Id;
import java.io.Serializable;
import java.util.List;

@Document(indexName = "pms_sku_info")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class PmsSkuInfoSearch implements Serializable {

    @Id
    private Long id;

    @Field(type = FieldType.Text, analyzer = "ik_max_word")
    private String skuName;

    @Field(type = FieldType.Text, analyzer = "ik_max_word")
    private String skuDesc;

    @Field(type = FieldType.Keyword)
    private Long catalog3Id;

    @Field(type = FieldType.Text)
    private String price;

    @Field(type = FieldType.Keyword, index = false)
    private String skuDefaultImg;

    @Field(type = FieldType.Double)
    private double hotScore;

    @Field(type = FieldType.Keyword)
    private Long spuId;

    private List<PmsSkuAttrValue> skuAttrValueList;
}
