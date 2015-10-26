package tutorial.rest.resources.asm;

import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import tutorial.core.services.util.BlogEntryList;
import tutorial.rest.mvc.BlogController;
import tutorial.rest.resources.BlogEntryListResource;
import tutorial.rest.resources.BlogEntryResource;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;


import java.util.List;

public class BlogEntryListResourceAsm extends ResourceAssemblerSupport<BlogEntryList, tutorial.rest.resources.BlogEntryListResource> {

    public BlogEntryListResourceAsm() {
        super(BlogController.class, BlogEntryListResource.class);
    }

    @Override
    public BlogEntryListResource toResource(BlogEntryList list) {

        List<BlogEntryResource> resources = new BlogEntryResourceAsm().toResources(list.getEntries());

        BlogEntryListResource listResource = new BlogEntryListResource();

        listResource.setEntries(resources);

        listResource.add( linkTo(methodOn(BlogController.class).findAllBlogEntries(list.getBlogId())).withSelfRel() );

        return listResource;
    }

}
