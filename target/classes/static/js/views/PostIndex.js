export default function PostIndex(props) {
    return `
        <header>
            <h1>Posts Page</h1>
        </header>
        <main>
            <div>
                <form>
                    <input id="add-post-title"> 
                    <button type="button" id="add-post-button">Submit</button>
                 </form>
            </div>
            <div>
                ${props.posts.map(post => `<h1>${post.title}</h1> <h3>${post.content}</h3>`).join('')}
            </div>
        </main>
    `;
}

export function postsEvent() {
    createAddPostListener();
}

function createAddPostListener() {
    console.log("adding add post listener");
    $("add-post-button").click(function () {
        const title = $(("add-post-button").val())
        // const newPost = {
        //     title,
        //     content
        // }
        console.log("Ready to add " + newPost)
    })
}