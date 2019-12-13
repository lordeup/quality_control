package com.files;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
  public String id;
  public String category_id;
  public String title;
  public String alias;
  public String content;
  public String price;
  public String old_price;
  public String status;
  public String keywords;
  public String description;
  public String hit;
}