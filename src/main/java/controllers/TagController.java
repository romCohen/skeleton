package controllers;

import api.ReceiptResponse;
import dao.TagDao;
import generated.tables.records.ReceiptsRecord;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Path("/tags")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class TagController {
    final TagDao tags;

    public TagController(TagDao tags) {
        this.tags = tags;
    }

    @PUT
    @Path("/{tag}")
    public void toggleTag(@PathParam("tag") String tagName, @Valid @NotNull Integer id) {
        tags.tagOrUntag(tagName,id);
    }

    @GET
    @Path("/{tag}")
    public List<ReceiptResponse> getReceiptsCorrespondingToTag(@PathParam("tag") String tagName){
        List<ReceiptsRecord> receiptRecords = tags.getReceiptsFromTag(tagName);
        return receiptRecords.stream().map(ReceiptResponse::new).collect(toList());
    }
}