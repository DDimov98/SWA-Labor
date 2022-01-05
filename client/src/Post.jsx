import React from "react";
import { withStyles } from '@material-ui/core/styles';

import Comments from './Comments';
import PostForm from './PostForm';
import FormControl from "@material-ui/core/FormControl";

const styles = theme => ({
	center: {
		width: "96%",
		padding: "2%",
		boxSizing: "borderBox",
		borderRadius: "3px 15px 5px 30px",
		background: "#5DCD",
		marginTop: "2%",
	},

	postForm: {
		marginLeft: "0%",
		width: "80%",
		padding: "2%",
		boxSizing: "borderBox",
		borderRadius: "10px 10px 0px 10px",
		background: "#5858",
		marginTop: "2%",
		fontFamily: "monospace",
		color: "black",
	},

	textForm: {
		marginLeft: "10%",
		width: "80%",
		padding: "2%",
		boxSizing: "borderBox",
		borderRadius: "0px 10px 10px 10px",
		background: "#A4A4A4",
		marginTop: "0%",
		fontFamily: "serif",
		color: "grey",
	},
});

class Post extends React.Component {

	constructor(props) {
		super(props);
	    this.state = {
			currentUser: this.props.currentUser,
            post: this.props.post,
			author: [],
			comments: [],
		};
	}

	componentDidMount()
	{
		fetch( "http://localhost:8080/Users/getUser?userId=" + this.props.author)
			.then( function(response) { return response.json() } )
			.then( data => this.setState({author: data }));
		this.setState({loading: false});
	}


render() {
		const { classes } = this.props;
	console.log( "Benutzer ist in Post:" + this.state.currentUser.username)
		return (
		<div className={classes.center}>

            <font >

				<div className={classes.postForm}>
					{this.state.author.username} schieb am {this.state.post.postedat.slice(0,10).replace("-",".").replace("-",".") } um {this.state.post.postedat.slice(11,16)}

				</div>

				<div className={classes.textForm}>
					{this.state.post.text}
				</div>

			</font>

			<Comments currentUser={this.state.currentUser} comments={this.state.comments} post={this.state.post}></Comments>
            <PostForm post = {this.state.post} currentUser={this.state.currentUser}></PostForm>
	    </div>
		);
	}
}

export default withStyles(styles)(Post);

